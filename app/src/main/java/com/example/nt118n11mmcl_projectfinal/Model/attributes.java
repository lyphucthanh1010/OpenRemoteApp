package com.example.nt118n11mmcl_projectfinal.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class attributes {
    public Object getTemperature() {
        return temperature;
    }

    public void setTemperature(Object temperature) {
        this.temperature = temperature;
    }

    public Object getHumidity() {
        return humidity;
    }

    public void setHumidity(Object humidity) {
        this.humidity = humidity;
    }

    public Object getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Object windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Object getNotes() {
        return notes;
    }

    public void setNotes(Object notes) {
        this.notes = notes;
    }

    public Object getChildAssetType() {
        return childAssetType;
    }

    public void setChildAssetType(Object childAssetType) {
        this.childAssetType = childAssetType;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getWriteAttribute() {
        return writeAttribute;
    }

    public void setWriteAttribute(Object writeAttribute) {
        this.writeAttribute = writeAttribute;
    }

    public Object getSubscribeAttribute() {
        return subscribeAttribute;
    }

    public void setSubscribeAttribute(Object subscribeAttribute) {
        this.subscribeAttribute = subscribeAttribute;
    }

    public Object getConsoleVersion() {
        return consoleVersion;
    }

    public void setConsoleVersion(Object consoleVersion) {
        this.consoleVersion = consoleVersion;
    }

    public Object getConsolePlatform() {
        return consolePlatform;
    }

    public void setConsolePlatform(Object consolePlatform) {
        this.consolePlatform = consolePlatform;
    }

    public Object getConsoleProvider() {
        return consoleProvider;
    }

    public void setConsoleProvider(Object consoleProvider) {
        this.consoleProvider = consoleProvider;
    }

    @SerializedName("consoleProvider")
    @Expose
    public Object consoleProvider;
    @SerializedName("consolePlatform")
    @Expose
    public Object consolePlatform;
    @SerializedName("consoleVersion")
    @Expose
    public Object consoleVersion;
    @SerializedName("subscribeAttribute")
    @Expose
    public Object subscribeAttribute;
    @SerializedName("writeAttribute")
    @Expose
    public Object writeAttribute;
    @SerializedName("data")
    @Expose
    public Object data;
    @SerializedName("childAssetType")
    @Expose
    public Object childAssetType;
    @SerializedName("notes")
    @Expose
    public Object notes;
    @SerializedName("temperature")
    @Expose
    public Object temperature;
    @SerializedName("humidity")
    @Expose
    public Object humidity;
    @SerializedName("agentDisabled")
    @Expose
    public Object agentDisabled;
    @SerializedName("requestTimeoutMillis")
    @Expose
    public Object requestTimeoutMillis;
    @SerializedName("followRedirects")
    @Expose
    public Object followRedirects;
    @SerializedName("pollingMillis")
    @Expose
    public Object pollingMillis;

    public Object getClientId() {
        return clientId;
    }

    public void setClientId(Object clientId) {
        this.clientId = clientId;
    }

    public Object getWebsocketPath() {
        return websocketPath;
    }

    public void setWebsocketPath(Object websocketPath) {
        this.websocketPath = websocketPath;
    }

    public Object getWebsocketQuery() {
        return websocketQuery;
    }

    public void setWebsocketQuery(Object websocketQuery) {
        this.websocketQuery = websocketQuery;
    }

    public Object getPort() {
        return port;
    }

    public void setPort(Object port) {
        this.port = port;
    }

    public Object getSecureMode() {
        return secureMode;
    }

    public void setSecureMode(Object secureMode) {
        this.secureMode = secureMode;
    }

    public Object getHost() {
        return host;
    }

    public void setHost(Object host) {
        this.host = host;
    }

    @SerializedName("clientId")
    @Expose
    public Object clientId;
    @SerializedName("websocketPath")
    @Expose
    public Object websocketPath;
    @SerializedName("websocketQuery")
    @Expose
    public Object websocketQuery;
    @SerializedName("port")
    @Expose
    public Object port;
    @SerializedName("secureMode")
    @Expose
    public Object secureMode;
    @SerializedName("host")
    @Expose
    public Object host;
    public Object getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(Object baseURL) {
        this.baseURL = baseURL;
    }

    @SerializedName("baseURL")
    @Expose
    public Object baseURL;

    public Object getAgentDisabled() {
        return agentDisabled;
    }

    public void setAgentDisabled(Object agentDisabled) {
        this.agentDisabled = agentDisabled;
    }

    public Object getAgentStatus() {
        return agentStatus;
    }

    public void setAgentStatus(Object agentStatus) {
        this.agentStatus = agentStatus;
    }

    @SerializedName("agentStatus")
    @Expose
    public Object agentStatus;

    public Object getLocation() {
        return location;
    }

    public void setLocation(Object location) {
        this.location = location;
    }

    public Object getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(Object weatherData) {
        this.weatherData = weatherData;
    }

    @SerializedName("weatherData")
    @Expose
    public Object weatherData;
    @SerializedName("location")
    @Expose
    public Object location;

    public Object getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(Object windDirection) {
        this.windDirection = windDirection;
    }

    @SerializedName("windDirection")
    @Expose
    public Object windDirection;
    @SerializedName("windSpeed")
    @Expose
    public Object windSpeed;
}
