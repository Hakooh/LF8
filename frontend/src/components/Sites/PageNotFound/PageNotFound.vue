<template>
  <div> {{ msg }}</div>
  <router-view/>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      posts: [],
      msg: "pageNotFound"
    }
  },
  mounted() {
    axios.get('http://localhost:8080/api/user/all')
        .then((response) => {
          this.posts = response.data
        })
  }
}
</script>