<template>
  <div class="DetailsPage">
    <h1 class="DetailsPage__header"> {{ festival.name }}</h1>
    <div class="DetailsPage__CommentManager">
      <CommentManager/>
    </div>
  </div>
  <router-view/>
</template>

<script>
export { default } from "./FestivalDetails";
</script>

<style lang="css">
@import "FestivalDetails.css";
</style>