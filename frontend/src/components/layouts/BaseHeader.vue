<template>
  <el-menu class="el-menu-demo" mode="horizontal">
    <router-link to="/">TestHome</router-link>
    <router-link to="/festivalTable">Test</router-link>
    <el-menu-item router=true index="1"> Home
    </el-menu-item>
    <el-menu-item router=true index="2"> Page2
      <router-link to="/festivalTable"/>
    </el-menu-item>
    <el-menu-item index="4" disabled>Info</el-menu-item>
    <el-menu-item index="5">Orders</el-menu-item>
    <el-menu-item h="full" @click="toggleDark()">
      <button class="border-none w-full bg-transparent cursor-pointer" style="height: var(--ep-menu-item-height);">
        <i inline-flex i="dark:ep-moon ep-sunny" />
      </button>
    </el-menu-item>
  </el-menu>
</template>


<script lang="ts" setup>
import { toggleDark } from '~/composables';
</script>
