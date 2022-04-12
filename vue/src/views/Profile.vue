<template>
  <div class="profile">
    <h1>Profile</h1>
    <div class="cards-container">
      <username-card class="profile-cards" />
      <my-pets class="profile-cards" />
      <my-playdates class="profile-cards" />
    </div>
  </div>
</template>

<script>
import UsernameCard from '@/components/profile/UsernameCard.vue';
import MyPets from '@/components/profile/MyPets.vue';
import MyPlaydates from '@/components/profile/MyPlaydates.vue';
export default {
  name: "profile",
  components: {
    UsernameCard,
    MyPets,
    MyPlaydates
  }
};
</script>

<style scoped>
  .profile {
    display: flex;
    flex-direction: column;
    align-items: center;
    text-align: center;
  }

  .cards-container{
    width: 90%;
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  .profile-cards{
    border-radius: 10px;
    text-align: center;
  }
</style>
