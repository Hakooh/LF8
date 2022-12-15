<template>
  <div class="DetailsPage">
    <h1 class="DetailsPage__header"> {{ festival.name }}</h1>
    <el-card v-for="shop in festival.shops" :key="shop.id" :label="shop.id" class="FestivalCards__Card">
      <div class="Festivals__festivalCardName">
        {{ shop.name }}
      </div>
      <div class="Festivals__festivalCardLocation">
        Location: {{ festival.festivalPlace }}
      </div>
      <div class="Festivals__festivalCardStartDate">
        starts: {{ festival.startDate }}
      </div>
      <div class="Festivals__festivalCardEndDate">
        ends: {{ festival.endDate }}
      </div>
      <el-button @click="$router.push('/festivals/shops/'+festival.shop.id)" :key="festival.shop.id">Details</el-button>
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