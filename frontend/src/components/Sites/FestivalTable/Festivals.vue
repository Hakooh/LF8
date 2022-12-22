<template>
  <div>
    <ul class="FestivalCards">
      <el-card v-for="festival in festivals" :key="festival.id" :label="festival.id" class="FestivalCards__Card">
        <div class="Festivals__festivalCardName">
          {{ festival.name }}
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
        <el-button @click="$router.push('/festivals/'+festival.id)" :key="festival.id">Details</el-button>
      </el-card>
    </ul>
  </div>
  <router-view/>
</template>

<script>
export { default } from "./Festivals";
</script>

<style lang="css">
@import "./Festivals.css";
</style>