<template>
  <div class="container">
    <h3 class="text-center mb-4 mt-4">Items</h3>
    <div class="container">
      <table class="table">
        <thead>
        <tr>
          <th>Id</th>
          <th>Content</th>
          <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="item in items" v-bind:key="item.id">
          <td>{{ item.id }}</td>
          <td>{{ item.content }}</td>
          <td><button v-on:click="deleteItem(item.id)">Delete</button></td>
        </tr>
        <tr>
          <td>X</td>
          <td><input v-model="newItemContent"></td>
          <td><button v-on:click="createNewItem(newItemContent)">Add</button></td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>
<script>
import ItemService from "@/services/ItemService";
import ListService from "@/services/ListService";
export default {
  name: "ItemsList",
  props: {
    listId: Number
  },
  data() {
    return {
      items: [],
      shoppingList: Object,
      newItemContent: "item"
    };
  },
  methods: {
    getListItems() {
      ListService.getListItems(this.listId)
          .then(response => {
            this.shoppingList = response.data;
            this.items = this.shoppingList["items"];
          });
    },
    createNewItem(content) {
      ItemService.createItem(content, this.listId)
          .then(() => {
            this.getListItems();
            this.newItemContent = "item";
          });
    },
    deleteItem(itemId) {
      ItemService.deleteItem(itemId)
          .then(() => {
            this.getListItems();
          });
    }
  },
  created() {
    this.getListItems();
  }
};
</script>
<style>
</style>