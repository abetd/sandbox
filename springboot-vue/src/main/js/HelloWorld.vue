<template>
  <div class="hello">
    <p>{{ msg }}</p>
  </div>
</template>

<script>
var message = 'hello world!'
if (process.env.NODE_ENV === 'development') {
  message = 'hello development'
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