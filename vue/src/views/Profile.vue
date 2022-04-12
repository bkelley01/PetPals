<template>
  <div class="profile">
    <h1>Profile</h1>
    <p>You must be authenticated to see your user profile</p>
    <username-card />
    <my-pets />
    <my-playdates />
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
