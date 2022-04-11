<template>
  <div id="login" class="text-center">
    <div class="logo">
    <img class="petpals-logo" src="@/images/petpals.png" />
    <h2 class="logo-text">Connect with pets and the city around you on PetPals.</h2>
    </div>
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <div id="login-container">
        <label for="username" class="sr-only" id="username-label">Username</label>
        <input
          type="text"
          id="username-field"
          class="form-control"
          placeholder="Username"
          v-model="user.username"
          required
          autofocus
        />
        <label for="password" class="sr-only" id="password-label">Password</label>
        <input
          type="password"
          id="password-field"
          class="form-control"
          placeholder="Password"
          v-model="user.password"
          required
        />
        
        <button type="submit" id="sign-in-button">Sign in</button>
        <router-link :to="{ name: 'register' }" id="sign-up-button">Need an account?</router-link>
      </div>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>
<style scoped>

.text-center {
  background-color: pink;
  height: 100vh;
}

.logo {
  display: block;
}

.logo-text {
  display: block;
  text-align: center;

}

.petpals-logo {
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 15%;
}

.form-signin {
  display: block;
  text-align: center;
  border: 50px;

}

h1 {
  text-align: center;
}

#login-container {
  display: grid;
  grid-template-areas: 
  "username-label username-field"
  "password-label password-field"
  "sign-in-button sign-in-button"
  "sign-up-button sign-up-button";
  width: 25%;
  margin: auto;
  row-gap: 5%;
  /* height: 200px; */
  /* grid-template-rows: 49% 49%; */
}

#username-label {
  grid-area: "username-label";
  /* height: 90%; */
}

#username-field {
  grid-area: "username-field";
  /* height: 90%; */
}

#password-label {
  grid-area: "password-label";
  /* height: 90%; */
}

#password-field {
  grid-area: "password-field";
  /* height: 90%; */
}

#sign-in-button {
  grid-area: "sign-in-button";
}

#sign-up-button {
  grid-area: "sign-up-button";
}

</style>