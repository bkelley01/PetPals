<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <!-- <label for="username" class="sr-only">Username</label> -->
      <div id="register-container">
        <input
          type="text"
          id="username"
          class="form-control"
          placeholder="Username"
          v-model="user.username"
          required
          autofocus
        />
        <!-- <label for="password" class="sr-only">Password</label> -->
        <input
          type="password"
          id="password"
          class="form-control"
          placeholder="Password"
          v-model="user.password"
          required
        />
        <input
          type="password"
          id="confirmPassword"
          class="form-control"
          placeholder="Confirm Password"
          v-model="user.confirmPassword"
          required
        />
        <button class="btn btn-lg btn-primary btn-block" type="submit" id="create-btn">Create Account</button>
        <button type="submit" id="have-account-btn"><router-link :to="{ name: 'login' }" id="have-account-text">Have an account?</router-link></button>
      </div>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style>

#register-container {
  display: grid;
  grid-template-areas: 
  "username"
  "password"
  "confirmPassword"
  "create-btn"
  "have-account-btn";
  width: 15%;
  margin: auto;
  row-gap: 5%;
  background-color: white;
  padding: 3%;
  padding-top: 20px;
  padding-bottom: 70px;
  border-radius: 10px;
}

#username {
  grid-area: username;
  border-radius: 5px;
  border-width: thin;
  height: 40px;
  border-style: solid;
  border-color: #f0f2f5;
}

#password {
  grid-area: password;
  border-radius: 5px;
  border-width: thin;
  height: 40px;
  border-style: solid;
  border-color: #f0f2f5;
}

#confirmPassword {
  grid-area: confirmPassword;
  border-radius: 5px;
  border-width: thin;
  height: 40px;
  border-style: solid;
  border-color: #f0f2f5;
}

#create-btn {
  grid-area: create-btn;
  width: 100%;
  margin: auto;
  background-color: #3399FF;
  color: white;
  border-radius: 5px;
  height: 40px;
  border: none;
  font-size: 16px;
}

#have-account-btn {
  grid-area: have-account-btn;
  margin-top: 5%;
  background-color: #42B72A;
  border-radius: 5px;
  height: 100%;
  width: 50%;
  margin-left: auto;
  margin-right: auto;
  border: none;
}

#have-account-text {
  color: white;
  text-decoration: none;
}

h1 {
  text-align: center;
}

input[type="text"] {
  font-size:16px;
  padding-left: 10px;
}

input[type="password"] {
  font-size:16px;
  padding-left: 10px;
}

</style>
