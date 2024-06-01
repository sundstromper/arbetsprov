<template>
    <div class="hello">
      
      <button @click="skapaData">Skapa testdata!</button>
    </div>
  </template>
<script>
import axios from 'axios';
export default {

  methods: {
      skapaData() {

          for (let i = 0; i < 50; i++) {
            let namn = "namn" + i
            let adress = "adress" + i
            let email = "email" + i
            let telephone = "telephone" + i
            const testobjekt = {
                'name' : namn,
                'address' : adress,
                'email' : email,
                'telephone' : telephone
            }
            console.log(testobjekt);
            try
            {
              axios.post("http://localhost:8080/ggid/user", testobjekt);

            }
            catch (error) {
              console.error(error);
            }
            
          }
        } 
    }   
  
  
};
</script>




  <style>
  button {
  padding: 12px 32px;
  font-size: 16px;
  border-radius: 8px;
  }
  </style>