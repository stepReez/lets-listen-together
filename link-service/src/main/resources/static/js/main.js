var linkApi = Vue.resource("/llt{/id}");

Vue.component('link-form', {
  data: function() {
    return {
        link: ''
    }
  },
  template: '<div>' +
                '<input type="text" placeholder="Add link" v-model="link" />' +
                '<input type="button" value="Save" @click="save" />' +
            '</div>',
  methods: {
    save: function() {
        var link = { link: this.link };
        linkApi.save({}, link).then(result =>
        result.json().then(data => {
            this.link = ''
        }));
    }
  }
});

var app = new Vue({
  el: '#app',
  template: '<link-form />',
  data: { messages: []}
});