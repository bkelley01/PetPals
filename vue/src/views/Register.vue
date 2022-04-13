<template>
    <div>
        <span v-if="this.$store.state.token">You successfully registered, add a pet to get started.</span>
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

</style>