/* 
    Filename: family.js
    Description: This file is on the persistence layer of the app and it includes 
                 queries to insert or get data from databse.
    Author: Maja Kitek
    Date: 2023-05-11
*/

const { Season } = require('../../models/time/seasonsModel');
const errorMessages = require('../../utils/errorMessages');

async function getSeasons()
{
    try
    {
        const seasons = await Season.findAll();
        return seasons.map((season) => season.toJSON());
    }
    catch (error)
    {
        throw new Error(errorMessages.RETURN_ERROR + errorMessages.SEASONS);
    }
};

async function createSeason(seasonData)
{
    try
    {
        const season = await Season.create(seasonData);
        return season.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.CREATE_ERROR + errorMessages.SEASON);
    }
};

async function getSeasonByName(seasonName)
{
    try
    {
        const season = await Season.findOne({
            where: { name: seasonName },
            returning: true
        });
        return season.toJSON();
    }
    catch(error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.SEASON);
    }
};

async function getSeasonById(seasonId)
{
    try
    {
        const season = await Family.findByPk(seasonId);
        return season.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.SEASON);
    }
};

async function updateSeason(seasonId, updates)
{
    try
    {
        const[season, [updatedSeason]] = await Season.update(updates, {
            where: {season_id: seasonId},
            returning: true
        });
        return updatedSeason.toJSON();
    }
    catch (error)
    {
        throw new Error(errorMessages.UPDATE_ERROR + errorMessages.SEASON);
    }
};

module.exports = {
    getSeasonById,
    getSeasonByName,
    getSeasons,
    createSeason,
    updateSeason
};