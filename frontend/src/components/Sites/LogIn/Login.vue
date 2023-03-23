<template>
  <div>
    <h1>LOGIN</h1>
    <form @click.prevent="login()">
      <input v-model="username" placeholder="username" />
      <br/>
      <br/>
      <input v-model="password" placeholder="password" type="password"/>
      <br/>
      <br/>
      <button type="submit">Login</button>
    </form>
  
  </div>
</template>

<script>
export { default } from "./LogIn";
</script>