import requests
import json
import os
from datetime import date, datetime, timedelta


class SlackApiClient:

    def __init__(self):
        self.token = os.getenv("SLACK_TOKEN")

    def users_list(self):
        api = 'https://slack.com/api/users.list?token={token}&pretty=1'
        url = api.format(token=self.token)
        response = self.get_json(url)
        return response["members"]

    def channels_list(self):
        api = 'https://slack.com/api/channels.list?token={token}&pretty=1'
        url = api.format(token=self.token)
        response = self.get_json(url)
        return response["channels"]

    def channels_history(self, channel_id):
        # TODO oldest and latest
        one_week_ago = datetime.now() - timedelta(days=7)
        oldest = one_week_ago.timestamp()
        latest = datetime.now().timestamp()
        count = 5
        api = 'https://slack.com/api/channels.history?token={token}&channel={channel}&latest={latest}&oldest={oldest}&count={count}&pretty=1'
        # count は デフォルト = 100
        url = api.format(token=self.token, channel=channel_id, latest=latest, oldest=oldest, count=count)
        response = self.get_json(url)
        print(response["ok"])
        # print(len(response["messages"]))
        for message in response["messages"]:
            # print(message["text"])
            print("reactions" in message.keys())
            if "reactions" in message.keys():
                for reaction in message["reactions"]:
                    print(reaction["name"])
                    print(message["text"])
        print(response["has_more"])
        if response["has_more"]:
            print(response["messages"][count-1]["ts"])
        return response["messages"]

    def get_json(self, url):
        response = requests.get(url)
        return json.loads(response.text)
