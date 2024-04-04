<template>
    <v-card outlined>
        <v-card-title>
            DecreasePoint
        </v-card-title>

        <v-card-text>
            <String label="UserId" v-model="value.userId" :editMode="editMode"/>
            <Number label="BookId" v-model="value.bookId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="decreasePoint"
            >
                DecreasePoint
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'DecreasePointCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.userId = '';
            this.value.bookId = 0;
        },
        watch: {
        },
        methods: {
            decreasePoint() {
                this.$emit('decreasePoint', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

