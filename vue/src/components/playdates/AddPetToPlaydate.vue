<template>
    <div>
        <div id="controls-div">
            <button id="join-btn" v-on:click="flipShowJoinPlaydate()" v-if="!showJoinPlaydate">Join Playdate</button>
            <select v-if="showJoinPlaydate" v-model.number="petSelected" id="select-pet-list" class="pet-list">
                <option v-for="pet in userPets" v-bind:key="pet.petId" :value="pet.petId">{{ pet.petName }}</option> <!-- :value="Object.values(pet)[0]" -->
            </select>        
            <button id="add-btn" v-on:click="addPetToPlaydate()" v-if="showJoinPlaydate"><i class="fas fa-check"></i></button>
            <button id="cancel-btn" v-on:click="flipShowJoinPlaydate()" v-if="showJoinPlaydate"><i class="fas fa-ban"></i></button>
        </div>
        
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

#controls-div {
    display: flex;
    flex-direction: row;

}

#join-btn {
    display: block;
    background-color: #3399FF;
    width: 150px;
    height: 26px;
    margin: auto;
    color: white;
    text-decoration: none;
    border: none;
    border-radius: 5px;
    font-size: 16px;
    cursor: pointer;
}

#cancel-btn {
    display: block;
    background-color: rgb(255, 74, 74);
    width: 70px;
    height: 20px;
    margin: auto;
    color: white;
    text-decoration: none;
    border: none;
    border-radius: 15px;
    font-size: 16px;
    cursor: pointer;
    height: 26px;
    /* font-weight: bolder; */
}

#add-btn {
    display: block;
    background-color: #3399FF;
    width: 70px;
    height: 20px;
    margin: auto;
    color: white;
    text-decoration: none;
    border: none;
    border-radius: 15px;
    font-size: 16px;
    cursor: pointer;
    height: 26px;
    margin-left: 5px;
}

#select-pet-list {
    width: 150px;
    height: 26px;
    border-radius: 5px;
}

</style>