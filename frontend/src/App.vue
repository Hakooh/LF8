<template>
  <el-config-provider namespace="ep">
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
  color-scheme: dark;}

.element-plus-logo {
  width: 100%;
  height: 180px;
}
</style>
