<template>
  <div class="pet-card" :key="pet.petId">
      <h3>{{pet.name}} </h3>
      <p>Type: </p>
      <p>Personalities: <span v-for="(personality, index) in pet.personalities" :key="index"> </span> </p>
  </div>
</template>

<script>
export default {
    name: "pet-card",
    props: ["pet"],
    computed: {
      fakeUser() {
        return this.$store.state.fakeUsers.find( p => p.username == this.$route.params.username);
      }
    }
}
</script>

<style>

.pet-card {
    border: 1px solid orange;
    width: 50%;
    border-radius: 10px;
}
</style>