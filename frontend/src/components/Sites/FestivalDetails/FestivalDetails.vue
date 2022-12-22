<template>
  <div class="DetailsPage">
    <h1 class="DetailsPage__header"> {{ festival.name }}</h1>
    <el-card v-for="shop in festival.shops" :key="shop.id" :label="shop.id" class="FestivalCards__Card">
      <div class="Festivals__festivalCardName">
        {{ shop.name }}
      </div>
      <div class="Festivals__festivalCardLocation">
        ShopTyp: {{ shop.type }}
      </div>
      <el-button @click="$router.push('/festivals/shops/'+shop.id)" :key="shop.id">Details</el-button>
    </el-card>
    <div class="DetailsPage__CommentManager">
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