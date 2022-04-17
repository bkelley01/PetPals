<template>
    <div>
        <h2>Find Pet Friends</h2>
        <label class="search-label">Pet Name</label>
        <input type="text" class="search-input"
        v-model="userChoices.petName" />
        <label>Personality</label>
        <select class="personality-menu" 
        v-model="userChoices.personality">
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
    </div>
</template>

<script>
export default {
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
    // computed: {
    //     filteredPets() {
    //         let fp = this.
    //         if (this.userChoices.)
    //     }
    // },


}
</script>

<style>

</style>