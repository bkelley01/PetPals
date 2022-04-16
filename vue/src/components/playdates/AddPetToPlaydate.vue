<template>
    <div>
        <button v-on:click="flipShowJoinPlaydate()" v-if="!showJoinPlaydate">Join Playdate</button>
        <button v-on:click="flipShowJoinPlaydate()" v-if="showJoinPlaydate">Cancel</button>
        <select v-if="showJoinPlaydate" v-model="petSelected" id="select-pet-list" class="pet-list">
            <option v-for="pet in userPets" v-bind:key="pet.petId">{{ pet.petName }}</option>
        </select>
        <button v-on:click="addPetToPlaydate()" v-if="showJoinPlaydate">Add {{test.playdateId}}</button>
    </div>
</template>

<script>
import petService from '@/services/PetService.js';


export default {
    props: [ "test" ],
    data() {
        return {
            petSelected: -1,
            userPets: [],
            showJoinPlaydate: false,
        }
    },
    created() {
        petService.getUserPets(this.$store.state.user.username).then(r => {
            this.userPets = r.data;
        });
    },
    methods: {
        flipShowJoinPlaydate() {
            this.showJoinPlaydate = !this.showJoinPlaydate;
        },
        addPetToPlaydate() {
            //console.log(this.petSelected);
            console.log(this.petSelected.petId);
            //petService.addPetToPlaydate();
            this.flipShowJoinPlaydate();
        }
    }
}
</script>

<style>

</style>