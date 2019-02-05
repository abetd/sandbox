<template>
  <div class="hello">
    <p>{{ msg }}</p>
  </div>
</template>

<script>
  import axios from 'axios'
  export default {
    name: 'helloworld',
    data () {
      return {
        msg: "hello world!"
      }
    },
    created: async function () {
      await this.refresh()
    },
    methods: {
      refresh: async function () {
        const response = await axios.get('http://localhost:8080/hello')
        this.msg = response.data
      }
    }
  }
</script>