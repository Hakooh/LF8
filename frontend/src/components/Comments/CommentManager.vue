<template>
  <div>
    <div>
      <div>
        <h2>Comments</h2>
      </div>
      <star-rating class="CommentManager__StarRating"
                   @update:rating="setRating"
                   v-model:rating="data.rating"
                   v-bind:increment="0.5"
                   v-bind:star-size="25"/>
      <textarea
                v-model="data.body"
                placeholder="Add a comment"
                class="border">
              </textarea>
      <div class="CommentManager__Buttons">
        <el-button @click="saveComment">Save</el-button>
        <el-button>Cancel</el-button>
      </div>
    </div>
    <comment v-for="comment in comments"
             :key="comment.id"
             :comment="comment"
             @comment-updated="updateComment($event)"
             @comment-deleted="deleteComment($event)">
    </comment>
  </div>
</template>


<script>
export { default } from "./CommentManager";
</script>


<style lang="css">
@import "./CommentManager.css";
</style>
