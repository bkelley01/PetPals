<template>
    <div>
        <h2 id="register-success" v-if="this.$store.state.token">You successfully registered, add a pet to get started.</h2>
        <add-pet v-if="this.$store.state.token"/>
        <register-form v-if="!this.$store.state.token"/>
    </div>
</template>

<script>
import registerForm from '@/components/RegisterForm.vue'
import addPet from '@/components/AddPet.vue'

export default {
    components: {
        registerForm,
        addPet
    }

}
</script>

<style>
#register-success {
    font-size: 20px;
    margin: 25px auto;
}


</style>