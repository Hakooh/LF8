<template>
  <div>{{ posts[0].firstName }}</div>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      posts: []
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