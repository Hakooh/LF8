<template>
  <div class="CommentItem">
    <div>
      <star-rating class="CommentItem__starRating"
                   v-model:rating="comment.rating"
                   v-bind:read-only="true"
                   v-bind:increment="0.5"
                   v-bind:star-size="15"/>
      <p>{{ comment.body }}</p>
      <el-button @click="state = 'editing'">Edit</el-button>
    </div>
    <div>
      <p>{{comment.author.name}} <span>&bull;</span>{{ comment.created_at}}</p>
    </div>
    <div v-show="state === 'editing'">
      <div>
        <h3>Update Comment</h3>
      </div>
      <textarea v-model="data.body"
                placeholder="Update comment"
                class="border">
            </textarea>
      <div>
        <el-button @click="saveEdit">Update</el-button>
        <el-button @click="resetEdit">Cancel</el-button>
        <el-button @click="deleteComment">Delete</el-button>
      </div>
    </div>
  </div>
</template>


<script>
export { default } from "./CommentItem"
</script>

<style lang="css">
@import "./CommentItem.css";
</style>