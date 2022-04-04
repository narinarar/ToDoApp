import React from 'react';
import {useState} from 'react';
import {View, TextInput, Button, StyleSheet, Modal, Image} from 'react-native';

function GoalInput(props) {
  const [enteredGoalText, setEnteredGoalText] = useState('');

  function goalInputHandler(enteredText) {
    setEnteredGoalText(enteredText);
  }

  function addGoalHandler() {
    props.onAddGoal(enteredGoalText);
    setEnteredGoalText('');
  }

  return (
    <Modal visible={props.visible} animationType="slide">
      <View style={styles.inputContainer}>
        <Image style={styles.image} source={require('../images/son.png')} />
        <TextInput
          style={styles.textInput}
          placeholder="Hedeflerin"
          onChangeText={goalInputHandler}
          value={enteredGoalText}
        />
        <View style={styles.buttonContainer}>
          <View style={styles.button}>
            <Button title="Ekle" onPress={addGoalHandler} color="#f66f9c" />
          </View>
          <View style={styles.button}>
            <Button title="İptal" onPress={props.onCancel} color="#f66f9c" />
          </View>
        </View>
      </View>
    </Modal>
  );
}

export default GoalInput;

const styles = StyleSheet.create({
  inputContainer: {
    flex: 1,
    flexDirection: 'column',
    justifyContent: 'center',
    alignItems: 'center',
    padding: 16,
    backgroundColor: 'white',
  },
  image: {
    resizeMode: 'center',
    width: 300,
    height: 300,
    margin: 18,
  },
  textInput: {
    borderWidth: 1,
    borderColor: '#f66f9c',
    backgroundColor: '#f66f9c',
    color: 'white',
    borderRadius: 6,
    width: '100%',
    padding: 16,
  },
  buttonContainer: {
    marginTop: 16,
    flexDirection: 'row',
  },
  button: {
    width: 100,
    marginHorizontal: 8,
  },
});
