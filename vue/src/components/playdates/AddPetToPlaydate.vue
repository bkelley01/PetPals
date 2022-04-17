<template>
    <div>
        <button v-on:click="flipShowJoinPlaydate()" v-if="!showJoinPlaydate">Join Playdate</button>
        <button v-on:click="flipShowJoinPlaydate()" v-if="showJoinPlaydate">Cancel</button>
        <select v-if="showJoinPlaydate" v-model.number="petSelected" id="select-pet-list" class="pet-list">
            <option v-for="pet in userPets" v-bind:key="pet.petId" :value="pet.petId">{{ pet.petName }}</option> <!-- :value="Object.values(pet)[0]" -->
        </select>
        <button v-on:click="addPetToPlaydate()" v-if="showJoinPlaydate">Add</button>
    </div>
</template>

<script>
import petService from '@/services/PetService.js';


export default {
    props: [ "playdate" ],
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
            petService.addPetToPlaydate(this.petSelected, this.playdate.playdateId)
            .then(e => {
                if (e.status === 201) {
                    let p = this.petName;
                    let pd = this.playdate.playdateTitle;
                    alert(`Successfully added ${p} to ${pd}`);
                    this.$router.go();
                }
            });
            this.flipShowJoinPlaydate();
        },
    
    },
    computed: {
        petName() {
            let computedPet = this.userPets.find(pet => {
                return this.petSelected === pet.petId
            });
            return computedPet.petName;
        }
    }
}
</script>

<style>

</style>