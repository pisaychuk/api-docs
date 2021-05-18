
##  Recording Available event

The Recording Available event is sent after a recording has been processed. It indicates that the recording is available for download.

### Expected response

```http
HTTP/1.1 204
```

### Properties
| Property          | Description |
|:------------------|:------------|
| eventType         | The event type, value is `recordingAvailable`. |
| eventTime         | The approximate UTC date and time when the event was generated by the Bandwidth server, in ISO 8601 format. This may not be exactly the time of event execution. |
| accountId         | The user account associated with the call. |
| applicationId     | The id of the application associated with the call. |
| to                | The phone number that received the call, in E.164 format (e.g. +15555555555). |
| from              | The phone number that made the call, in E.164 format (e.g. +15555555555). |   
| direction         | The direction of the call. Either `inbound` or `outbound`. The direction of a call never changes. |
| callId            | The call id associated with the event. |
| parentCallId      | (optional) If the event is related to the B leg of a `<Transfer>`, the call id of the original call leg that executed the `<Transfer>`. Otherwise, this field will not be present. |
| recordingId       | The unique id for this recording. |
| channels          | Number of channels in the recording (1 or 2). |
| startTime         | The time that the recording started (in ISO8601 format). |
| endTime           | The time that the recording ended (in ISO8601 format). |
| duration          | The duration of the recording (in ISO8601 format). |
| fileFormat        | The audio format that the recording was saved as (`wav` or `mp3`). |
| callUrl           | The URL of the call associated with the event. |
| mediaUrl          | The URL of the recording media. |
| tag               | (optional) The `tag` specified earlier in the call. If no `tag` was specified or it was previously cleared, this field will not be present. |
| status            | The state of the recording. Can be `complete`, `partial`, or `error`. A `partial` status indicates that, although the recording is available to be downloaded, parts of the recording are missing. |
| transferCallerId  | (optional) If the event is related to the B leg of a `<Transfer>`, the phone number used as the `from` field of the B-leg call, in E.164 format (e.g. +15555555555). Otherwise, this field will not be present. |
| transferTo        | (optional) If the event is related to the B leg of a `<Transfer>`, the phone number used as the `to` field of the B-leg call in E.164 format (e.g. +15555555555). Otherwise, this field will not be present. |



#### Example: Recording Available event

```
POST http://[External server URL]
```

```json
{
	"eventType"     : "recordingAvailable",
	"eventTime"     : "2019-09-13T16:49:40.500",
	"accountId"     : "55555555",
	"applicationId" : "7fc9698a-b04a-468b-9e8f-91238c0d0086",
	"to"            : "+15553334444",
	"from"          : "+15551112222",
	"direction"     : "outbound",
	"callId"        : "c-95ac8d6e-1a31c52e-b38f-4198-93c1-51633ec68f8d",
	"recordingId"   : "r-115da407-e3d9-4ea7-889f-5f4ad7386a80",
	"channels"      : 1,
	"startTime"     : "2019-09-13T16:48:29.235Z",
	"endTime"       : "2019-09-13T16:48:48.890Z",
	"duration"      : "PT20.056S",
	"fileFormat"    : "wav",
	"callUrl"       : "https://../{accountId}/calls/{callId-1}",
	"mediaUrl"      : "https://../{accountId}/calls/{callId-1}/recordings/{recordingId}/media",
	"status"        : "complete"
}
```

