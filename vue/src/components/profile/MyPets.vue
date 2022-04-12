<template>
  <div class="container">
    <div>
      <h2>My Pets</h2>
      <p>List of Pets</p> 
    </div>
    <pet-card v-for="pet in fakeUser.pets" :key="pet.petId" :pet="pet" />
  </div>
</template>

<script>
import PetCard from '@/components/profile/PetCard.vue';
export default {
  components: { PetCard },
    name: "my-pets",
    computed: {
      fakeUser() {
        return this.$store.state.fakeUsers.find( p => p.username == this.$route.params.username);
      }
    },
    created() {
      const username = this.$route.params.username;
      console.log(username);
    }
}
</script>

<style scoped>
.container {
    width: 80%;
    border: 1px solid green;
    margin-top: 15px;
    display: flex;
    flex-direction: column;
    align-items: center;
}
</style>