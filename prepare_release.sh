#!/usr/bin/env bash

# Arguments:
# $1: version
# $2: vendor
# $3: target
# $4: subtarget
# $5: device
# $6: image
do_prepare() {
    mkdir -p dist/$1/$2/$3/$4
    cp openwrt/bin/targets/$3/$4/chirpstack-gateway-os-$1-$6-$3-$4-$5* dist/$1/$2/$3/$4
}

do_prepare $1 raspberrypi bcm27xx bcm2708 rpi base
do_prepare $1 raspberrypi bcm27xx bcm2708 rpi full
do_prepare $1 raspberrypi bcm27xx bcm2709 rpi-2 base
do_prepare $1 raspberrypi bcm27xx bcm2709 rpi-2 full
