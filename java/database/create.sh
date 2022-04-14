#!/bin/bash
BASEDIR=$(dirname $0)
DATABASE=final_capstone
psql -U postgres -f "$BASEDIR/dropdb.sql" &&
createdb -U postgres $DATABASE &&
psql -U postgres -d $DATABASE -f "$BASEDIR/schema.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/pet.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/playdate.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/pet_personality.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/pet_playdate.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/user.sql"
