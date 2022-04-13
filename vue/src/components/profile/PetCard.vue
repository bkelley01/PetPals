<template>
  <div class="pet-card" :key="pet.petId">
    <div id="first-letter">{{ pet.name.charAt(0) }}</div>
    <div id="pet-details-container">
      <h3 id="name">{{ pet.name }}</h3>
      <p id="type">{{ pet.type }}</p>
      <ul>
        <li
        class="personalities"
        v-for="(personality, index) in pet.personalities"
        :key="index"
      >
        {{ personality }}
      </li>
      </ul>
      <!-- <span
        id="personalities"
        v-for="(personality, index) in pet.personalities"
        :key="index"
      >
        {{ personality }}
        <span id="vertical-bar" v-if="index != pet.personalities.length - 1">
          |
        </span>
      </span> -->
    </div>
  </div>
</template>

<script>
export default {
  name: "pet-card",
  props: ["pet"],
  computed: {
    fakeUser() {
      return this.$store.state.fakeUsers.find(
        (p) => p.username == this.$route.params.username
      );
    },
  },
};
</script>

<style>
.pet-card {
  margin: 5px 0px 5px 0px;
  padding: 10px;
  border-radius: 15px;
  width: 80%;
  border: 2px solid #eecd22ff;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-around;
}

#first-letter {
  /* border: 3px solid #40a8a0ff; */
  line-height: 30px;
  padding: 20px;
  border-radius: 50%;
  font-size: 2em;
  height: 30px;
  width: 30px;
 color: white;
 background-color: #40a8a0;
}

h3 {
  margin: 0px;
}

.personalities {
  list-style-type: none;
  width: 100%;
}

ul {
  padding: 0;
}

li {
  margin: 0px;
}

/* @media screen and (max-width: 768px) {
  #vertical-bar {
    display: none;
  }
} */
</style>