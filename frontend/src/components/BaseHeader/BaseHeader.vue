<template>
  <el-menu :router="true" class="el-menu-demo" mode="horizontal">
    <el-menu-item index="/"> Home
    </el-menu-item>
    <el-menu-item index="/festivals"> FestivalTable
    </el-menu-item>
    <el-menu-item index="4" disabled>Info</el-menu-item>
    <el-menu-item class="el-menu-darkmode" index="" h="full" @click="toggleDark()">
      <button class="border-none w-full bg-transparent cursor-pointer" style="height: var(--ep-menu-item-height);">
        <i inline-flex i="dark:ep-moon ep-sunny" />
      </button>
    </el-menu-item>
    <el-menu-item v-if="!isLoggedIn" index="/login">
      Login
    </el-menu-item>
  </el-menu>
</template>


<script>
import { toggleDark } from '~/composables';
export { default } from "./BaseHeader";
</script>

<style lang="css">
.el-menu-demo{
  padding-left:4%;
}

.el-menu-darkmode {
}
</style>
