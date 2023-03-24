<template>
  <el-config-provider namespace="ep">
    <img alt="Vue logo" class="element-plus-logo" src="./assets/Banner.png" />
    <BaseHeader />
    <div style="display: flex">
      <div>
        <router-view/>
      </div>
    </div>
    <ChatBot />
  </el-config-provider>
</template>

<style>
#app {
  text-align: center;
  color: var(--ep-text-color-primary);
}

.element-plus-logo {
  width: 100%;
  height: 180px;
}
</style>
