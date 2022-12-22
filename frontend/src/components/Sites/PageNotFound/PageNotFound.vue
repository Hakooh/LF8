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
}
</script>