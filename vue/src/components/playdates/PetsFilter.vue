<template>
    <div id="main-find-pets">
        <div id="find-pets-main-div">
            <div id=find-pets-filter-div>
                <h2>Find Pet Friends</h2>
                <form id="pet-filter-form">
                    <label class="search-label">Pet Name</label>
                    <input 
                    type="text" 
                    class="pet-search-field"
                    v-model="userChoices.petName" 
                    required />

                    <label class="search-label">Personality</label>
                    <select id="personality-select" 
                    class="pet-search-field"
                    v-model="userChoices.personality">
                        <option value="">All Personalities</option>
                        <option v-for="(personality, index) in this.$store.state.personalityOptions" 
                        v-bind:key="index" 
                        v-bind:value="personality">{{personality}}</option>
                    </select>

                    <label class="search-label">Pet Type</label>
                    <select id="pet-type-select"
                    class="pet-search-field"
                    v-model="userChoices.petType">
                        <option value="">All Types</option>
                        <option value="Dog">Dog</option>
                        <option value="Cat">Cat</option>
                    </select>
                </form>
            </div>

            <div id="pets-results-div">
            <mini-pet-card v-for="pet in filteredPets" v-bind:key="pet.petId" v-bind:pet="pet"/>
            </div>
        </div>
    </div>
</template>

<script>
import MiniPetCard from '@/components/playdates/MiniPetCard.vue';
import petService from '@/services/PetService.js';

export default {
  components: { MiniPetCard },
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
#find-pets-filter-div {
  margin: auto;
  margin-bottom: 10px;
  padding: 10px;
  border-radius: 15px;
  /* width: 400px; */
  /* background-color: white; */
  /* align-items: center; */
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-around;
}

.pet-search-field {
    width: 250px;
    height: 34px;
    border-radius: 5px;
    font-size: 20px;
    border: 1px solid #d1d1d1;
}

#pets-results-div {
    margin: auto;
    display: flex;
    flex-wrap: wrap;
}

.search-label {
    padding: 20px;
    font-size: 20px;
}

</style>