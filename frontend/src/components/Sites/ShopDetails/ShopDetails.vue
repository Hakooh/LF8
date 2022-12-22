<template>
  <div class="DetailsPage">
    <h1 class="DetailsPage__header"> {{ shops.name }}</h1>
    <el-card class="FestivalCards__Card">
      <div class="Festivals__festivalCardName">
        {{ shops.type }}
      </div>
    </el-card>
    <div class="DetailsPage__CommentManager">
      <CommentManager/>
    </div>
  </div>
  <router-view/>
</template>

<script>
export { default } from "./ShopDetails";
</script>

<style lang="css">
@import "ShopDetails.css";
</style>