<template>
    <div>
        <h2>Find Pet Friends</h2>
        <form>
            <label class="search-label">Pet Name</label>
            <input 
            type="text" 
            class="search-input"
            v-model="userChoices.petName" 
            required />

            <label>Personality</label>
            <select v-model="userChoices.personality">
                <option value=""></option>
                <option v-for="(personality, index) in this.$store.state.personalityOptions" 
                v-bind:key="index" 
                v-bind:value="personality">{{personality}}</option>
            </select>

            <label>Pet Type</label>
            <select class="pet-type-menu"
            v-model="userChoices.petType">
                <option value=""></option>
                <option value="Dog">Dog</option>
                <option value="Cat">Cat</option>
            </select>

        </form>

        <pet-card v-for="pet in filteredPets" v-bind:key="pet.petId" v-bind:pet="pet"/>
    </div>
</template>

<script>
import PetCard from '../profile/PetCard.vue';
import petService from '@/services/PetService.js';

export default {
  components: { PetCard },
    data() {
        return {
            userChoices: {
                petName: '',
                personality: '',
                petType: ''
            },
            pets: []
        }
    },
    created() {
        petService.getAllPets().then(r => {
            this.pets = r.data;
        })
    },
    computed: {
        filteredPets() {
            let fp = this.pets;
            if (this.userChoices.petName != "") {
                fp = fp.filter(curPet => {
                    return curPet.petName.toLowerCase().includes(this.userChoices.petName.toLowerCase());
                });
            }
            if (this.userChoices.personality != "") {
                fp = fp.filter(curPet => {
                    return curPet.personalities.includes(this.userChoices.personality);
                });
            }
            if (this.userChoices.petType != "") {
                fp = fp.filter(curPet => {
                    return curPet.petType === this.userChoices.petType;
                });
            }
            return fp;
        }
    }
}
</script>

<style>

</style>