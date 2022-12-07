<template>
  <img src="./assets/logo.png" alt="VueLogo">
  <div>
    <p>
      If Element Plus is successfully added to this project, you'll see an
      <code v-text="'<el-button>'"></code>
      below
    </p>
    <el-button type="primary">el-button</el-button>
  </div>
  <Homepage/>
</template>

<script>
import homepage from './components/example/Homepage'

export default {
  name: 'App',
  components: {
    homepage
  }
}
</script>