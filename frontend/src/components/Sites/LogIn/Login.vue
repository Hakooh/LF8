<template>
  <div>
    <h1>LOGIN</h1>
    <form>
      <input v-model="email" placeholder="username" />
      <br/>
      <br/>
      <input v-model="password" placeholder="password" type="password"/>
      <br/>
      <br/>
      <button @click.prevent="login()" type="submit">Login</button>
    </form>
  
  </div>
</template>

<script>
export { default } from "./LogIn";
</script>