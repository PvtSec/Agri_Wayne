# Agri Wayne

![](https://github.com/PvtSec/Agri_Wayne/raw/master/app/src/main/res/drawable-mdpi/app_icon.png)

![](https://img.shields.io/github/stars/pandao/editor.md.svg)
![](https://img.shields.io/github/forks/pandao/editor.md.svg)
![](https://img.shields.io/github/tag/pandao/editor.md.svg)
![](https://img.shields.io/github/release/pandao/editor.md.svg)
![](https://img.shields.io/github/issues/pandao/editor.md.svg)
![](https://img.shields.io/bower/v/editor.md.svg)

#### Features

- Realtime Weather Monitoring
- Regional Weather Predictions
- Crop suggestions with respect to Weather conditions
- Advisory to improve crop productivity

#### Building the app locally
- Download the repo as zip or use the command below:
- `git clone https://github.com/PvtSec/Agri_Wayne.git`
- Open the project in Android Studio and wait for the files to be synced with gradle (May require different gradle version, so wait for gradle to be downloaded)
- The api requests are made to a php script hosted online. Change the link in the file:
`java > agri.wayne > ServerHandler > ServerCommunication.java`
edit the line 37 to point to another php script
- php is not necessary, but the api response should be always json
Required format of api response:
```json
{
    "Weather": {
        "Date": "Sunday, April 26, 2020",
        "Today": {
            "ImageId": 1,
            "Statement": "Mostly Sunny",
            "Temperature": "32",
            "Rainfall": "0",
            "Humidity": "67",
            "Wind Speed": "2.5",
            "Condition": {
                "Good": {
                    "Coffee": {
                        "Watering": {
                            "1": "Advisory statement 1",
                            "2": "Advisory statement 2",
                            "3": "Advisory statement 3"
                        },
                        "Fertilizer": {
                            "1": "Advisory statement 4",
                            "2": "Advisory statement 5",
                            "3": "Advisory statement 6"
                        },
                        "Pesticides": {
                            "1": "Advisory statement 7",
                            "2": "Advisory statement 8",
                            "3": "Advisory statement 9"
                        }
                    }
                },
                "Normal": {
                    "Ginger": {
                        "Watering": {
                            "1": "Advisory statement 1",
                            "2": "Advisory statement 2",
                            "3": "Advisory statement 3"
                        },
                        "Fertilizer": {
                            "1": "Advisory statement 4",
                            "2": "Advisory statement 5",
                            "3": "Advisory statement 6"
                        },
                        "Pesticides": {
                            "1": "Advisory statement 7",
                            "2": "Advisory statement 8",
                            "3": "Advisory statement 9"
                        }
                    },
                    "Banana": {
                        "Watering": {
                            "1": "Advisory statement 1",
                            "2": "Advisory statement 2",
                            "3": "Advisory statement 3"
                        },
                        "Fertilizer": {
                            "1": "Advisory statement 4",
                            "2": "Advisory statement 5",
                            "3": "Advisory statement 6"
                        },
                        "Pesticides": {
                            "1": "Advisory statement 7",
                            "2": "Advisory statement 8",
                            "3": "Advisory statement 9"
                        }
                    }
                },
                "Bad": {
                    "Rice": {
                        "Watering": {
                            "1": "Advisory statement 1",
                            "2": "Advisory statement 2",
                            "3": "Advisory statement 3"
                        },
                        "Fertilizer": {
                            "1": "Advisory statement 4",
                            "2": "Advisory statement 5",
                            "3": "Advisory statement 6"
                        },
                        "Pesticides": {
                            "1": "Advisory statement 7",
                            "2": "Advisory statement 8",
                            "3": "Advisory statement 9"
                        }
                    }
                }
            }
        },
        "Tomorrow": {
            "ImageId": 2,
            "Statement": "Cloudy",
            "Temperature": "27",
            "Rainfall": "0",
            "Humidity": "92",
            "Wind Speed": "5.5",
            "Condition": {
                "Good": {
                    "Banana": {
                        "Watering": {
                            "1": "Advisory statement 1",
                            "2": "Advisory statement 2",
                            "3": "Advisory statement 3"
                        },
                        "Fertilizer": {
                            "1": "Advisory statement 4",
                            "2": "Advisory statement 5",
                            "3": "Advisory statement 6"
                        },
                        "Pesticides": {
                            "1": "Advisory statement 7",
                            "2": "Advisory statement 8",
                            "3": "Advisory statement 9"
                        }
                    }
                },
                "Normal": {
                    "Ginger": {
                        "Watering": {
                            "1": "Advisory statement 1",
                            "2": "Advisory statement 2",
                            "3": "Advisory statement 3"
                        },
                        "Fertilizer": {
                            "1": "Advisory statement 4",
                            "2": "Advisory statement 5",
                            "3": "Advisory statement 6"
                        },
                        "Pesticides": {
                            "1": "Advisory statement 7",
                            "2": "Advisory statement 8",
                            "3": "Advisory statement 9"
                        }
                    },
                    "Rice": {
                        "Watering": {
                            "1": "Advisory statement 1",
                            "2": "Advisory statement 2",
                            "3": "Advisory statement 3"
                        },
                        "Fertilizer": {
                            "1": "Advisory statement 4",
                            "2": "Advisory statement 5",
                            "3": "Advisory statement 6"
                        },
                        "Pesticides": {
                            "1": "Advisory statement 7",
                            "2": "Advisory statement 8",
                            "3": "Advisory statement 9"
                        }
                    }
                },
                "Bad": {
                    "Coffee": {
                        "Watering": {
                            "1": "Advisory statement 1",
                            "2": "Advisory statement 2",
                            "3": "Advisory statement 3"
                        },
                        "Fertilizer": {
                            "1": "Advisory statement 4",
                            "2": "Advisory statement 5",
                            "3": "Advisory statement 6"
                        },
                        "Pesticides": {
                            "1": "Advisory statement 7",
                            "2": "Advisory statement 8",
                            "3": "Advisory statement 9"
                        }
                    }
                }
            }
        },
        "Next Week": {
            "ImageId": 3,
            "Statement": "Heavy Shower",
            "Temperature": "17",
            "Rainfall": "12.6",
            "Humidity": "76",
            "Wind Speed": "2.5",
            "Condition": {
                "Good": {
                    "Coffee": {
                        "Watering": {
                            "1": "Advisory statement 1",
                            "2": "Advisory statement 2",
                            "3": "Advisory statement 3"
                        },
                        "Fertilizer": {
                            "1": "Advisory statement 4",
                            "2": "Advisory statement 5",
                            "3": "Advisory statement 6"
                        },
                        "Pesticides": {
                            "1": "Advisory statement 7",
                            "2": "Advisory statement 8",
                            "3": "Advisory statement 9"
                        }
                    }
                },
                "Normal": {
                    "Banana": {
                        "Watering": {
                            "1": "Advisory statement 1",
                            "2": "Advisory statement 2",
                            "3": "Advisory statement 3"
                        },
                        "Fertilizer": {
                            "1": "Advisory statement 4",
                            "2": "Advisory statement 5",
                            "3": "Advisory statement 6"
                        },
                        "Pesticides": {
                            "1": "Advisory statement 7",
                            "2": "Advisory statement 8",
                            "3": "Advisory statement 9"
                        }
                    }
                },
                "Bad": {
                    "Ginger": {
                        "Watering": {
                            "1": "Advisory statement 1",
                            "2": "Advisory statement 2",
                            "3": "Advisory statement 3"
                        },
                        "Fertilizer": {
                            "1": "Advisory statement 4",
                            "2": "Advisory statement 5",
                            "3": "Advisory statement 6"
                        },
                        "Pesticides": {
                            "1": "Advisory statement 7",
                            "2": "Advisory statement 8",
                            "3": "Advisory statement 9"
                        }
                    },
                    "Rice": {
                        "Watering": {
                            "1": "Advisory statement 1",
                            "2": "Advisory statement 2",
                            "3": "Advisory statement 3"
                        },
                        "Fertilizer": {
                            "1": "Advisory statement 4",
                            "2": "Advisory statement 5",
                            "3": "Advisory statement 6"
                        },
                        "Pesticides": {
                            "1": "Advisory statement 7",
                            "2": "Advisory statement 8",
                            "3": "Advisory statement 9"
                        }
                    }
                }
            }
        }
    }
}
```
- When the api response is set correctly, the app can be built for test.
- On receiving the api response correctly, the app starts showing all required data
