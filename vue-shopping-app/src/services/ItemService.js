import axios from "axios";
const BASE_API_URL = "http://localhost:8080/api/v1";
const ITEM_API_URL = `${BASE_API_URL}/item/`;
class ItemService {
    createItem(content, listId) {
        const item = {"content": content};
        return axios.post(ITEM_API_URL + listId, item);
    }

    deleteItem(itemId) {
        return axios.delete(ITEM_API_URL + itemId);
    }
}
export default new ItemService();