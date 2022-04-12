<template>
  <div class="container">
    <div class="title">
      <h2>{{fakeUser.username}}'s Pets</h2> 
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
.title{
  width: 50%;
}

.container {
  width: 100%;
  background: white;
  /* border: 1px solid #eecd22ff; */
  margin-top: 15px;
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>