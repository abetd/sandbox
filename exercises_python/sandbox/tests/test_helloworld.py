import unittest
from helloworld import hello


class TestHelloworld(unittest.TestCase):
    def test_hello(self):
        self.assertEqual("Hello World.", hello())


if __name__ == "__main__":
    unittest.main()
