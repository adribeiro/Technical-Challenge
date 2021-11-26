/* Script for button 1 */
const getEasternStandardTime = async() =>{
    console.log("Eastern Standard Time!");
    
    try {
        const dataJson = await consumeAPI('est');
        verifyAndCreateData(dataJson)
    } catch (error) {
        console.log('Erro');
        console.log(error);
    } 
}

/* Script for button 2 */
const getCoordinatedUniversalTime = async() =>{
    console.log("Coordinated Universal Time!");
    
    try {
        const dataJson = await consumeAPI('utc');
        verifyAndCreateData(dataJson)
    } catch (error) {
        console.log('Erro');
        console.log(error);
    } 
}

/* Script for button 3 */
const getCentralEuropeanStandardTime = async() =>{
    console.log("Central European Standard Time!");

    try {
        const dataJson = await consumeAPI('cet');
        verifyAndCreateData(dataJson)
    } catch (error) {
        console.log('Erro');
        console.log(error);
    } 
}

/* Request to an Rest API */
const consumeAPI = async(timezone) =>{
    const url = `http://worldclockapi.com/api/json/${timezone}/now`;
    let dataJson = {}
    try{
        const data = await fetch(url);
        dataJson = await data.json();
    }catch(error){
        console.log('Error');
        console.log(error);
    }
    return dataJson
}

/* Check if the data received from api has all the properties necessary */
const verifyAndCreateData = (dataJson) => {
    try {

        if (dataJson.hasOwnProperty('currentDateTime') && dataJson.currentDateTime !== null
            && dataJson.hasOwnProperty('dayOfTheWeek') && dataJson.dayOfTheWeek !== null
            && dataJson.hasOwnProperty('utcOffset') && dataJson.utcOffset !== null
        ) {
            createRowInTable(dataJson);
        }else{
            console.log('Bad Data');
            console.log(dataJson)
        }
    } catch (error) {
        console.log('Error verifyAndCreateData');
        console.log(error);
    } 
}

/* Create a row and append it to the table */
const createRowInTable = (time) => {
    console.log(time)
    
    
    /* Creating columns */
    const tdCurrentDateTime = document.createElement("td");
    tdCurrentDateTime.innerHTML = time.currentDateTime
    
    const tdDayOfTheWeek = document.createElement("td");
    tdDayOfTheWeek.innerHTML = time.dayOfTheWeek
    
    const tdTimeZoneName = document.createElement("td");
    tdTimeZoneName.innerHTML = time.timeZoneName
    
    const tdUtcOffset = document.createElement("td");
    tdUtcOffset.innerHTML = time.utcOffset
    
    /* Creating a row and appending the collumns */
    const row = document.createElement("tr");
    row.appendChild(tdCurrentDateTime);
    row.appendChild(tdDayOfTheWeek);
    row.appendChild(tdTimeZoneName);
    row.appendChild(tdUtcOffset);
    
    /* Appending the row created to the table */
    try {
        const tableOfTime = document.getElementById("table");
        tableOfTime.appendChild(row);
    } catch (error) {
        console.log('Error createRowInTable');
        console.log(error);
    }
    
}

/* Adding listeners to the buttons */
document.getElementById('EST').addEventListener('click',getEasternStandardTime);
document.getElementById('CUT').addEventListener('click',getCoordinatedUniversalTime);
document.getElementById('CEST').addEventListener('click',getCentralEuropeanStandardTime);