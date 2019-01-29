import Vue from 'vue'
import HelloWorld from './HelloWorld.vue'

var hello = new Vue({
    el: '#hello',
    components: { HelloWorld },
    template: '<HelloWorld />'
})

var hello2 = new Vue({
    el: '#hello2',
    components: { HelloWorld },
    template: '<HelloWorld />'
})

