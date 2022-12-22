<template>
  <div>
    <div>
      <form name="form" @submit.prevent="handleLogin">
        <div class="form-group">
          <label for="username">Username</label>
          <input
          type="text"
          class="form-control"
          name="username"
          />
          <div
            v-if="errors.has('username')"
            class="alert alert-danger"
            role="alert">
            Username is required!
          </div>
        </div>
        <div class="form-group">
          <label for="password">Password</label>
          <input
          v-model="user.password"
          type="password"
          class="form-control"
          name="password"
          />
          <div
            v-if="errors.has('password')"
            class="alert alert-danger"
            role="alert"
          >
            Password is required!
          </div>
        </div>
        <div class="form-group">
          <el-button :disabled="loading">
            <span
              v-show="loading"
              class="spinner-border spinner-border-sm"
            />
            <span>Login</span>
          </el-button>
        </div>
        <div class="form-group">
          <div v-if="message" class="alert alert-danger" role="alert">
            {{ message }}
          </div>
        </div>
      </form>
    </div>
  </div>
</template>

