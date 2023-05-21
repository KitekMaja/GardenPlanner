/* 
    Filename: plantOrder.js
    Description: This file is on the persistence layer of the app and it includes 
                 queries to insert or get data from databse.
    Author: Maja Kitek
    Date: 2023-05-10
*/

const { PlantOrder } = require('../../models/scientific_classification/plantOrderModel');
const errorMessages = require('../../utils/errorMessages');

async function getOrders()
{
    try
    {
        const orders = await PlantOrder.findAll();
        return orders.map((plant_order) => plant_order.toJSON());
    }
    catch (error)
    {
        throw new Error(errorMessages.RETURN_ERROR + errorMessages.PLANT_ORDERS);
    }
};

async function createOrder(orderData)
{
    try
    {
        const plantOrder = await PlantOrder.create(orderData);
        return plantOrder.toJSON();
    }
    catch (error)
    {
        throw new Error(errorMessages.CREATE_ERROR + errorMessages.PLANT_ORDER);
    }
}

async function getOrderByName(orderName)
{
    try
    {
        const plantOrder = await PlantOrder.findOne({
            where: { name: orderName },
            returning: true
        });
        return plantOrder.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.PLANT_ORDER);
    }
}

async function getOrderById(orderId)
{
    try
    {
        const plantOrder = await PlantOrder.findByPk(orderId);
        return plantOrder.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.PLANT_ORDER);
    }
};

async function updateOrder(orderId, updates)
{
    try
    {
        const[plantOrder, [updatedOrder]] = await PlantOrder.update(updates, {
            where: {order_id: orderId},
            returning: true
        });
        return updatedOrder.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.UPDATE_ERROR + errorMessages.PLANT_ORDER);
    }
}

module.exports ={
    getOrders,
    getOrderById,
    getOrderByName,
    createOrder,
    updateOrder
};