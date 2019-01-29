<template>
  <div class="hello">
    <p>{{ msg }}</p>
  </div>
</template>

<script>
var message = 'hello world!'
if (NODE_ENV === 'develop') {
  message = 'hello develop'
}
export default {
  name: 'helloworld',
  data () {
    return {
      msg: message
    }
  }
}
</script>