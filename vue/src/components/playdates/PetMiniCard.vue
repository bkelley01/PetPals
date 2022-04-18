<template>
    <div id="mini-pet-card-container">
        <h3>Pet Name</h3>
        <p>Type: 
            <i class="fas fa-dog"></i>
            <i class="fas fa-cat"></i>
        </p>
        <!-- <h3>

            v-for="pet in filteredPets" v-bind:key="pet.petId" v-bind:pet="pet"
            Pet Name
            <i v-if="pet.petType === 'Dog'" class="fas fa-dog"></i>
            <i v-if="pet.petType === 'Cat'" class="fas fa-cat"></i>
        </h3>
        <div id="pet-details">
            <p><i class="far fa-user"></i>{{pet.username}}</p>
            <p v-on:click="showPlaydates = !showPlaydates">Playdates</p>
            
            
        </div> -->
    </div>
</template>

<script>
export default {
    name: "pet-mini-card",
    props: ["pet"],
    data() {
        return {
            showPlaydates: false
        }
    }

}
</script>

<style>
#mini-pet-card-container {
    border: 1px solid red;
    background-color: white;
}
</style>